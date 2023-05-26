package v1.advanced

fun main() {
    var ls = Solution()

    var a = (ListNode(1))
    var b = (ListNode(2))
    var c = (ListNode(4))
    a.next = b
    b.next = c

    var d = (ListNode(1))
    var e = (ListNode(3))
    var f = (ListNode(4))
    d.next = e
    e.next = f

    ls.mergeTwoLists(a, d)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val listOfAll = ArrayList<ListNode>()
        recursFunc(list1, list2, listOfAll)

        val theFirstEl = listOfAll.firstOrNull() ?: return null

        return listOfAll.foldIndexed(theFirstEl) { index, acc, element ->
            val actual = ListNode(element.`val`)
            if (index == 0) actual
            else actual.apply { actual.next = acc }
        }
    }

    private fun recursFunc(firstList: ListNode? = null, secondList: ListNode? = null, listOfAll: ArrayList<ListNode>) {
        if (firstList?.`val` != null) {
            listOfAll.add(firstList)
            recursFunc(firstList = firstList.next, listOfAll = listOfAll)
        }
        if (secondList?.`val` != null) {
            listOfAll.add(secondList)
            recursFunc(secondList = secondList.next, listOfAll = listOfAll)
        }

        listOfAll.sortByDescending { it.`val` }
    }

    fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
        val sequence = generateSequence(listOfNotNull(list1, list2)) { currentList ->
            currentList.flatMap { it.next?.let { listOf(it) } ?: emptyList() }
        }

        val resultList = sequence.flatMap { it.map { ListNode(it.`val`) } }
        return resultList.firstOrNull()
    }
}