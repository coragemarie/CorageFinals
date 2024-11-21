
package coragefinals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ExamGraphClass {
     private Map<String, Set<String>> mapfriends;

    public ExamGraphClass () {
        mapfriends = new HashMap<>();
    }
    public void addUserName (String user) {
        mapfriends.putIfAbsent(user, new HashSet<>());
    }
     public void addFriendName(String user1, String user2) {
        mapfriends.putIfAbsent(user1, new HashSet<>());
        mapfriends.putIfAbsent(user2, new HashSet<>());
        mapfriends.get(user1).add(user2);
        mapfriends.get(user2).add(user1);
    }
      public void displayAllFriends() {
        for (var entry : mapfriends.entrySet()) {
            System.out.print(entry.getKey() + "'s friends: ");
            for (String friend : entry.getValue()) {
                System.out.print(friend + " ");
            }
            System.out.println();
        }
      }
      public Set<String> getRecommendedFriendsNames(String user) {
        Set<String> reco = new HashSet<>();
        Set<String> userFriends = mapfriends.getOrDefault(user, new HashSet<>());

        for (String friend : userFriends) {
            for (String friendsFriend : mapfriends.getOrDefault(friend, new HashSet<>())) {
                if (!userFriends.contains(friendsFriend) && !friendsFriend.equals(user)) {
                    reco.add(friendsFriend);
                }
            }
        }
        return reco;
    }
}



