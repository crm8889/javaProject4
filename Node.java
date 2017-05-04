class Node
   {
   private static final int ORDER = 4;
   private int numItems;
   private Node parent;
   private Node childArray[] = new Node[ORDER];
   private DataItem itemArray[] = new DataItem[ORDER-1];

   // connect child to this node
   public void connectChild(int childNum, Node child)
      {
      childArray[childNum] = child;
      if(child != null)
         child.parent = this;
      }

   // disconnect child from this node, return it
   public Node disconnectChild(int childNum)
      {
      Node tempNode = childArray[childNum];
      childArray[childNum] = null;
      return tempNode;
      }

   public Node getChild(int childNum)
      { return childArray[childNum]; }

   public Node getParent()
      { return parent; }

   public boolean isLeaf()
      { return (childArray[0]==null) ? true : false; }

   public int getNumItems()
     { return numItems; }

   public DataItem getItem(int index) 
      { return itemArray[index]; }

   public boolean isFull()
      { return (numItems==ORDER-1) ? true : false; }

   // return index of item (within node) if found, otherwise -1
   public int findItem(long key)       
      {  
      for(int j=0; j<ORDER-1; j++)
         { 
         if(itemArray[j] == null)
            break;
         else if(itemArray[j].dData == key)
            return j;
         }
      return -1;
      }  // end findItem

   public int insertItem(DataItem newItem)
      {
      // assumes node is not full
      numItems++; 
      long newKey = newItem.dData;         // key of new item

      // start on right, and examine items
      for(int j=ORDER-2; j>=0; j--)        
         {  
         if(itemArray[j] == null)
            continue;                      // go left one cell
         else // not null,
            {                              
            long itsKey = itemArray[j].dData; // get its key
            if(newKey < itsKey)               // if it's bigger
               itemArray[j+1] = itemArray[j]; // shift it right
            else // insert new item in the middle
               {
               itemArray[j+1] = newItem;   
               return j+1;                 // return index of new item
               }
            }  // end else (not null)
         }  // end for                     // shifted all items,
      itemArray[0] = newItem;              // insert new item on the left
      return 0;                            // return index of new item
      }  // end insertItem()

   public DataItem removeItem()        // remove largest item
      {
      // assumes node not empty
      DataItem temp = itemArray[numItems-1];  // save item
      itemArray[numItems-1] = null;           // disconnect it
      numItems--;                             // one less item
      return temp;                            // return item
      }

   public void displayNode()           // format "/24/56/74/"
      {
      for(int j=0; j<numItems; j++)
         itemArray[j].displayItem();   // "/56"
      System.out.println("/");         // final "/"
      }
   
   // you may wish to add the more common/useful toString method
   }