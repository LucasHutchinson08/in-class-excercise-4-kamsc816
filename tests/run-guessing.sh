#!/bin/bash

# Run GuessingGame tests only
echo "Running GuessingGame tests..."

# Resolve ICE-4 directory from this script's location
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
ICE_DIR="${SCRIPT_DIR%/tests}"

cd "$ICE_DIR" || exit 1

mvn -q -f "$ICE_DIR/pom.xml" -Dtest=GuessingGameTest test && echo "✅ GuessingGame tests passed" || echo "❌ GuessingGame tests failed"
