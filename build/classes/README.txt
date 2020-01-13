Trie
In trie I have made a root which act as a root of binary tree From that I have extended all the string.
In insert first I check till where the letters are already present in the trie then I will add the nodes of the remaining letters and in the node of the last letter I will add the object.
In search First I check weather all the letters are present or not If not then return false else I will check that there is object in the last letter of the key if not then return false else true.
In matched I first I found all the letters are present or not if yes then from last letter I go to all the next nodes and print the node if it has object with it (that is it has been inserted before).
In delete first I check weather the key is present or not by serch if yes then I go the last letter and make its object null then from there I start to go back as If the letter has 0 child then delete it and go to its parent. I apply this recursive step till either I reached to root or I reach a node with 1 child.
In print I have used the algo of breadth first traversal I store the letters of all the level in a temporary array and sort it using a extra function sort and then print the level.
In print level I had just used the print function to that level and printed the level which is required instead of whle trie.

RBTree
In search I have used the same algo as of normal bst. If greater than parent then go right if smaller then go left till you find the key or leaf node.
In insert first I insert the node normally then colour it red. Then I have consider 4 cases and applied them as thought in class. 
1st case it is a root then paint it black
2nd case parent is black do nothing
3rd case parent is red
Subcase 3.1 uncle is red then recolour the uncle and parent as black and child as  black and colour the grand parent red then repeat all the 4 case to grandparent .
Subcase 3.2 uncle is black In this case we have to do recolouring and restructure by seeing which 4 case it is LL,LR RL,RR with respect to grandparent. 
Priority Queue
In this I have applied max heap by using array list. I have visualized a tree as array and given index starting from root by giving 0 to root and increasing the number as we go left to right in tree.
In insert I first add the element the last of heap then I compare it to its parent if it is smaller then it is done else swap it with its parent and repeated it till I found the root(0th index) or child is smaller than parent.
In exteact max I return the value of 0th eleent and then to maintain the heap I first put the last element to 0th position and delete the last element. Now I compare the 0th index node with its child if both are small then done else swap with the greater one then I repeat this with this child as a parent. Till I found the leaf or till both children are smaller than parent.
For FIFO I have maintained a side by side array which store the value when that key was entered so when we compare first we compare with marks then when it was entered.

Project Management
In project management I have made trie for allProject and all user and made arraylist for alljobs,finshed jobs and notfinished jobs and Maxheap of jobs.
In handle_user and handle_project I direcltly create user and project and add it to alluser and allproject.
In handle_job I first see weather the project and user exist or not if yes then I create the job and add it to the alljobheap and alljobarray I have also made prioeity1 which stores the value when it was created so I compare the jobs First by priority of project then by priority1 value of job that is when it was added.
Job exexcution: I extract the job with highest priority from the heap then I see if it can be completed or not if not then I send it to the unfinished job and then extract the next key till I find the job which can be executed. The job whicc is executed is sent to the finishedjobs array and marked the satus 1 that is completed.
Add: In add function I add the budget of that project and then I loop through the unfinshed array and iinsert the job with same project to the heap.
In run_to_completion I recursive execute job till the heap is not empty.
In the print stats I loop through the finished jobs and print them and then the unfinshedjobs.
In handle query I first loop through the alljobsarray and see the existence of job if job exist the according to status I return the output.If the job does not exist then I print NO JOB EXIST.



