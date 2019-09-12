// 332. Reconstruct Itinerary
// Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

// Note:

// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// All airports are represented by three capital letters (IATA code).
// You may assume all tickets form at least one valid itinerary.

class Solution {
    HashMap<String,PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets)
        {
            if(map.containsKey(ticket.get(0)))
            {
                map.get(ticket.get(0)).add(ticket.get(1));
            }
            else
            {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.add(ticket.get(1));
                map.put(ticket.get(0),q);
            }
        }
        visit("JFK");
        return res;
    }
    
    public void visit(String str){
        while(map.containsKey(str) && !map.get(str).isEmpty())
        {
            visit(map.get(str).poll());
        }
        res.add(0,str);
    }
}