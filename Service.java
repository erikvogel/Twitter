
public class Service {
	
		private static Service service = null;	
		private Tree tree;
		
		private Service() {
			tree = Tree.getInstance();
		}
		
		public static Service getInstance() {
			
			if (service == null)
				service = new Service();
			return service;
		}
		
		public boolean addGroup(String groupName, String parentName) {
			return tree.addGroup(groupName, parentName);
		}
		
		public boolean addUser(String userName, String groupName) {
			return tree.addUser(userName, groupName);
		}
		
		private boolean follow(String subjectName, String followerName, boolean follow) {
			if (subjectName.equals(followerName))
				return false;
			
			TwitterUser subject = tree.getUser(subjectName);
			TwitterUser follower = tree.getUser(followerName);
			if (subject == null || follower == null)
				return false;
			
			return true;
		}
		
		public TwitterUser getUser(String userName) {
			return tree.getUser(userName);
		}
		
		public boolean removeGroup(String groupName) {
			return tree.removeGroup(groupName);
		}
		
		
		public boolean removeUser(String userID) {
			return tree.removeUser(userID);
		}
		
		public boolean unfollow(String subjectID, String followerID) {
			return follow(subjectID, followerID, false);
		}
	}

