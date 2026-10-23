rootProject.name = "Java-OOP"

// Every folder (up to two levels deep) with a src directory is a module, e.g. :006-Solid:Lab
rootDir.walkTopDown()
    .maxDepth(2)
    .filter { it != rootDir && !it.name.startsWith(".") && it.resolve("src").isDirectory }
    .forEach { include(it.relativeTo(rootDir).path.replace(File.separatorChar, ':')) }
