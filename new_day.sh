#!/bin/bash
# Usage: ./new_day.sh 02 Variables VariablesDemo
# Creates Day02-Variables/Variables/VariablesDemo.java + notes.md

if [ "$#" -ne 3 ]; then
  echo "Usage: ./new_day.sh <day-number e.g. 02> <TopicFolderName> <MainClassName>"
  exit 1
fi

DAY_NUM=$1
TOPIC=$2
CLASSNAME=$3

DAY_DIR="Day${DAY_NUM}-${TOPIC}/${TOPIC}"
mkdir -p "$DAY_DIR"

cat > "${DAY_DIR}/${CLASSNAME}.java" <<EOF
public class ${CLASSNAME} {
    public static void main(String[] args) {
        // Day ${DAY_NUM}: ${TOPIC}
        System.out.println("Day ${DAY_NUM} - ${TOPIC}");
    }
}
EOF

cat > "${DAY_DIR}/notes.md" <<EOF
# Day ${DAY_NUM} - ${TOPIC}

## What I learned
-

## Commands I ran
\`\`\`bash
javac ${CLASSNAME}.java
java ${CLASSNAME}
\`\`\`

## Questions / things to revisit
-
EOF

echo "Created ${DAY_DIR}/${CLASSNAME}.java and notes.md"
echo "Don't forget to update the Progress Log table in README.md!"
