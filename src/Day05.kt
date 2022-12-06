fun main() {

    fun part1(input: List<String>): String {
        var tops = ""
        //read the file to figure out how many stacks
        var numStacks = 0
        for (line in input) {
            if (line[1] == '1') {
                numStacks = line.split(" ").last().toInt()
                break
            }
        }

        //make an array for that many stacks
        //var stacks:MutableList<MutableList<Char>>=mutableListOf(mutableListOf())
        val stacks = MutableList(numStacks) { mutableListOf<Char>() }
        var readingCrates = true
        //read the file to put boxes in stacks
        for (line in input) {
            var spaceCounter = 0
            var stackCounter = 0
            if (readingCrates) {
                for (c in line.toCharArray()) {
                    if (c == ' ' || c == '[') {
                        spaceCounter++
                        if (spaceCounter == 4) {
                            stackCounter++
                            spaceCounter = 0
                        }
                    }
                    if (c.isLetter()) {
                        if (c == 'm') {
                            readingCrates = false
                            break
                        }
                        spaceCounter++
                        if (spaceCounter == 4) {
                            stackCounter++
                            spaceCounter = 0
                        }
                        stacks[stackCounter].add(c)
                    }
                }
            } else {
                //read the instructions
                var split=line.split(' ')
                var moveItems=split[1].toInt()
                var from=split[3].toInt()
                var to=split[5].toInt()
                //and move the boxes as they say
                println(split)
            }
        }

        //read the first letter of all the stacks into its own string
        return tops
    }

    fun part2(input: List<String>): String {
        var tops = ""
        return tops
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    //check(part2(testInput) == ?)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
