# Makefile for cleaning Java class files in the project

# Define the directories where .class files are located
CLASS_DIRS = src/com/example/interpreter src/com/example/interpreter/conditions

# Target to clean all .class files
clean:
	@echo "Removing all .class files..."
	@find $(CLASS_DIRS) -type f -name "*.class" -delete 2>/dev/null || echo "No .class files found or directories do not exist."
	@echo "Clean complete."

.PHONY: clean