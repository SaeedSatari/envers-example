#!/bin/sh
FILES=$(git diff --cached --name-only --diff-filter=ACMR "*.java" | sed 's| |\\ |g')
[ -z "$FILES" ] && exit 0

mvn prettier:write

echo "$FILES" | xargs git add