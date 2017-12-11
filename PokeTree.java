import Species.Pokemon;
/** Binary tree implementation using PokeNodes.

@author Evan Paresa, adapted from 
        code provided by William McDaniel Albritton
@since 2017-11-20
*/
public class PokeTree {
   /** Root node. */
   private PokeNode root = null;
   /** Constructor. */
   public PokeTree() {
      return;
   }
   /** Add to root.
   
   @param p Pokémon to add to tree */
   public void add(Pokemon p) {
      root = add(root, p);
   }
   /** Add to tree. 
   
   @param node PokeNode to add item to
   @param p Pokémon to add to tree
   @return new node */
   private PokeNode add(PokeNode node, Pokemon p) {
      // base case: empty tree or end of leaf
      if (node == null) {
         return new PokeNode(p, 1, null, null);
      }
      // base case: duplicate node, so add 1 to PokeNode
      else if (p.compareTo(node.getPokemon()) == 0) {
         node.increaseNumCaught();
         return node;
      }
      else {
         // recursive case:
         // if p is less than current node, move to left child node
         if (p.compareTo(node.getPokemon()) < 0) {
            // set the node's left child to the left subtree with p added
            node.setLChild(add(node.getLChild(), p));
            return node;
         }
         // recursive case:
         // if p is greater than current node, move to right child node
         else {
            // set the node's right child to the right subtree with p added
            node.setRChild(add(node.getRChild(), p));
            return node;
         }
      }
   }
   /** Remove from root.
   
   @param p Pokémon to remove from tree */
   public void remove(Pokemon p) {
      root = remove(root, p);
   }
   /** Remove from tree.
   
   @param node PokeNode to remove item from
   @param p Pokémon to remove from tree
   @return PokeNode */
   private PokeNode remove(PokeNode node, Pokemon p) {
      if (node == null) { // if not found, throw exception
         throw new TreeException("Item not found!");
      } else {
         if (p == node.getPokemon()) {
            node.decreaseNumCaught();
         }
         if (node.getNumCaught() == 0) {
            // remove Pokémon from tree
            if (node.getLChild() == null && node.getRChild() == null) {
               // if node has no children, delete the node
               node = null;
            } else if (node.getLChild() == null) { 
               // right child must exist
               node = node.getRChild();
            } else if (node.getRChild() == null) { 
               // left child must exist
               node = node.getLChild();
            } else { 
               // both children exist
               node = getLargestNode(node.getLChild());
               node.setLChild(removeLargestNode(node.getLChild()));
            }
         } // end removing from tree
      }
      return node;
   }
   /** Get largest node within the tree
   
   @param node current PokeNode
   @return PokeNode */
   public PokeNode getLargestNode(PokeNode node) {
      if (node.getRChild() == null) {
         // if no right item, this is the largest item
         return node;
      } else {
         // if right item, keep traversing
         return getLargestNode(node.getRChild());
      }
   }
   /** Remove largest node within the tree
   
   @param node current PokeNode
   @return PokeNode */
   public PokeNode removeLargestNode(PokeNode node) {
      if (node.getRChild() == null) {
         // if no right item, this is the largest item
         // replace with left item
         return node.getLChild();
      } else {
         // if right item, keep looking and replace eventually
         node.setRChild(this.removeLargestNode(node.getRChild()));
         return node;
      }
   }
   /** Get item from root.
   
   @param searchKey Pokémon to search for
   @return the retrieved Pokémon */
   public Pokemon get(Pokemon searchKey) {
      return get(root, searchKey);
   }
   /** Get item from tree.
   
   @param node PokeNode to search
   @param searchKey Pokémon to look for
   @return the retrieved Pokémon */
   private Pokemon get(PokeNode node, Pokemon searchKey) {
      if (node == null) { // if not found, throw exception
         throw new TreeException("Item not found!");
      } else {
         // base case:
         // if the search key matches, return the item's address
         if (searchKey.getNumber() == node.getPokemon().getNumber()) {
            return node.getPokemon();
         }
         // if the search key of the searchKey is less than the node,
         // then search the left subtree
         else if (searchKey.getNumber() < node.getPokemon().getNumber()) {
            return get(node.getLChild(), searchKey);
         }
         // if the search key of this searchKey is greater than the node,
         // then search the right subtree
         else {
            return get(node.getRChild(), searchKey);
         }
      }
   }
   /**
   Overloaded wrapper method.
   
   Access private data field `root` to send to recursive method.
   */
   public String printPokeTree() {
      return preorderPokeTree(root);
   }
   /**
   Recursive preorder traversal method.
   
   Prints tree to System.out.
   
   @param base the root of the tree
   */
   private String preorderPokeTree(PokeNode base) {
      String result = "";
      if (base != null) {
         result += (" " + base.getPokemon().toString()
                            + "Caught: " + base.getNumCaught()
                            + "\n\n");
         result += preorderPokeTree(base.getLChild());
         result += preorderPokeTree(base.getRChild());
         
      }
      return result;
   }
   /** Rotates tree right.
   
   @param base current PokeNode
   @return PokeNode */
   private PokeNode rotateRight(PokeNode base) {
      PokeNode baseLChild = base.getLChild();
      base.setLChild(baseLChild.getRChild());
      baseLChild.setRChild(base);
      
      return baseLChild;
   }
   /** Rotates tree left.
   
   @param base current PokeNode
   @return PokeNode */
   private PokeNode rotateLeft(PokeNode base) {
      PokeNode baseRChild = base.getRChild();
      base.setRChild(baseRChild.getLChild());
      baseRChild.setLChild(base);
      
      return baseRChild;
   }
   
}