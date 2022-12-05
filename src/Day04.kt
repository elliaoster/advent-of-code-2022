fun main() {

    fun part1(input: List<String>): Int {
        var counter = 0
        for (line in input) {
            //find the first range
            val beforeComma = line.split(",").first()
            val firstP1 = beforeComma.split("-").first().toInt()
            val firstP2 = beforeComma.split("-").last().toInt()

            //find the second range
            val afterComma = line.split(",").last()
            val secondP1 = afterComma.split("-").first().toInt()
            val secondP2 = afterComma.split("-").last().toInt()

            //see if the one fully contains the second
            if ((firstP1 <= secondP1 && firstP2 >= secondP2) || (secondP1 <= firstP1 && secondP2 >= firstP2)) {
                //add one to counter
                counter++
            }
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        for (line in input) {
            //find the first range
            val beforeComma = line.split(",").first()
            val firstP1 = beforeComma.split("-").first().toInt()
            val firstP2 = beforeComma.split("-").last().toInt()

            //find the second range
            val afterComma = line.split(",").last()
            val secondP1 = afterComma.split("-").first().toInt()
            val secondP2 = afterComma.split("-").last().toInt()

            //see if the one partially contains the second
            if (secondP1 in firstP1..firstP2 || firstP1 in secondP1..secondP2) {
                //add one to counter
                counter++
            }
        }
        return counter
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
