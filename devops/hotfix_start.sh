#!/bin/bash
set -e

SCRIPT_PATH="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

if [ $# -ne 1 ]
then
        echo 'Usage: hotfix_start.sh <hotfix-version>'
        echo 'For example:'
        echo 'hotfix_start.sh 0.2.1'
        exit 2
fi

HOTFIX_VERSION=$1
HOTFIX_SNAPSHOT_VERSION="${HOTFIX_VERSION}-SNAPSHOT"

DEVELOP_BRANCH=develop
MASTER_BRANCH=master
HOTFIX_BRANCH="hotfix-${HOTFIX_VERSION}"

source $SCRIPT_PATH/hooks.sh

git checkout $MASTER_BRANCH && git pull
git checkout -b $HOTFIX_BRANCH

set_modules_version $HOTFIX_SNAPSHOT_VERSION

if ! git diff-files --quiet --ignore-submodules --
then
  # commit hotfix versions
  git commit -am "Start hotfix $HOTFIX_SNAPSHOT_VERSION"
else
  echo "Nothing to commit..."
fi

echo "# Okay, now you've got a new hotfix branch called $HOTFIX_BRANCH"
echo "# Please check if everything looks as expected and then push."
echo "# Use this command to push your created hotfix-branch:"
echo "git push --set-upstream origin $HOTFIX_BRANCH"
