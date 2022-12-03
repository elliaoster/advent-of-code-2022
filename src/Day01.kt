fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var elfLine = 0

        for (line in input) {
            if (line.isEmpty()) {
                elfLine = 0
            } else {
                elfLine = elfLine + line.toInt()
                if (elfLine > max) {
                    max = elfLine
                }
            }
        }

        return max
    }

    fun part2old(input: List<String>): Int {
        var max = 0
        var max2 = 0
        var max3 = 0

        var elfLine = 0
        for (line in input) {
            if (line.isEmpty()) {
                if (elfLine > max) {
                    max3 = max2
                    max2 = max
                    max = elfLine
                } else if (elfLine > max2) {
                    max3 = max2
                    max2 = elfLine
                } else if (elfLine > max3) {
                    max3 = elfLine
                }
                elfLine = 0
            } else {
                elfLine = elfLine + line.toInt()
            }
        }
        if (elfLine > max) {
            max3 = max2
            max2 = max
            max = elfLine
        } else if (elfLine > max2) {
            max3 = max2
            max2 = elfLine
        } else if (elfLine > max3) {
            max3 = elfLine
        }

        return max + max2 + max3
    }

    fun part2(input: List<String>): Int {
        var elves = arrayListOf<Int>()

        var elfLine = 0
        for (i in 0..input.size - 1) {
            if (!input[i].isEmpty()) {
                elfLine = elfLine + input[i].toInt()
            }
            if (input[i].isEmpty()||i == input.size - 1) {
                elves.add(elfLine)
                elfLine = 0
            }
        }

        var max = 0
        var max2 = 0
        var max3 = 0
        for (elf in elves) {
            if (elf > max) {
                max3 = max2
                max2 = max
                max = elf
            } else if (elf > max2) {
                max3 = max2
                max2 = elf
            } else if (elf > max3) {
                max3 = elf
            }
        }

        return max + max2 + max3
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
