fun main() {

    fun findPriority(commonChar: Char) = when (commonChar) {
        'a' -> 1
        'b' -> 2
        'c' -> 3
        'd' -> 4
        'e' -> 5
        'f' -> 6
        'g' -> 7
        'h' -> 8
        'i' -> 9
        'j' -> 10
        'k' -> 11
        'l' -> 12
        'm' -> 13
        'n' -> 14
        'o' -> 15
        'p' -> 16
        'q' -> 17
        'r' -> 18
        's' -> 19
        't' -> 20
        'u' -> 21
        'v' -> 22
        'w' -> 23
        'x' -> 24
        'y' -> 25
        'z' -> 26
        'A' -> 27
        'B' -> 28
        'C' -> 29
        'D' -> 30
        'E' -> 31
        'F' -> 32
        'G' -> 33
        'H' -> 34
        'I' -> 35
        'J' -> 36
        'K' -> 37
        'L' -> 38
        'M' -> 39
        'N' -> 40
        'O' -> 41
        'P' -> 42
        'Q' -> 43
        'R' -> 44
        'S' -> 45
        'T' -> 46
        'U' -> 47
        'V' -> 48
        'W' -> 49
        'X' -> 50
        'Y' -> 51
        'Z' -> 52
        else -> 0
    }

    fun part1(input: List<String>): Int {
        var total=0
        //go through each line
        for (line in input) {
            //split the line
            val half = line.length / 2
            val chars = line.toCharArray()
            val firstHalf = CharArray(half)
            for (i in 0..half - 1) {
                firstHalf[i] = chars[i]
            }

            var commonChar = ' '
            //find the common letter
            for (i in half..line.lastIndex) {
                for (j in 0..half - 1) {
                    if (chars[i] == firstHalf[j]) {
                        commonChar = chars[i]
                    }
                }
            }
            //find the prority of letter
            total+=findPriority(commonChar)
        }

        //return the sum
        return total
    }

    fun part2(input: List<String>): Int {
        var total=0
        //go through each line
        for (lineIndex in 0 .. input.size-3 step 3) {
            var commonChar = ' '
            val chars = input[lineIndex].toCharArray()
            val nextLinechars = input[lineIndex+1].toCharArray()
            val thirdLinechars = input[lineIndex+2].toCharArray()

            //walk through each char in the next line
            for (curr in 0..chars.lastIndex) {
                for (next in 0..nextLinechars.lastIndex) {
                    if (chars[curr]==nextLinechars[next]) {
                        for (third in 0..thirdLinechars.lastIndex) {
                            if (chars[curr]==thirdLinechars[third]) {
                                commonChar=chars[curr]
                            }
                        }
                    }
                }
            }
            //println(commonChar)

            //find the prority of letter
            total+=findPriority(commonChar)
        }

        //return the sum
        return total
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
