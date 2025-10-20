#!/bin/bash

# Run ShoppingCart tests only
echo "Running ShoppingCart tests..."

# Resolve ICE-4 directory from this script's location
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
ICE_DIR="${SCRIPT_DIR%/tests}"

cd "$ICE_DIR" || exit 1

mvn -q -f "$ICE_DIR/pom.xml" -Dtest=ShoppingCartTest test && echo "✅ ShoppingCart tests passed" || echo "❌ ShoppingCart tests failed"
