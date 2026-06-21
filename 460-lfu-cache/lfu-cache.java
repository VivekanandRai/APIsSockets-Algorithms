class LFUCache {
    int capacity;
    HashMap<Integer , dll> freqm;
    HashMap<Integer, node> keynodemap=new HashMap<>();
    int minfreq;

    class node{
        node prev;
        node next;
        int key;
        int val;
        int freq;
        public node(int x , int y , int z){
            key=x;
            val=y;
            freq=z;
        }
    }

    class dll{
        node head;
        node tail;
        int size;
        public dll(){
            head= new node(-1,-1,0);
            tail=new node(-1,-1,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        void addnode(node n){
            node nxt= head.next;

            n.next=nxt;
            nxt.prev=n;

            n.prev=head;
            head.next=n;
            size++;
        }
        void remove(node n){
            n.next.prev=n.prev;
            n.prev.next=n.next;

            size--;
        }
        node removelast(){
            if(size==0) return null;

            node ex= tail.prev;

            tail.prev.prev.next=tail;
            tail.prev= tail.prev.prev;

            size--;
            return ex;
        }

    }

    public LFUCache(int capacity) {
        this.capacity=capacity;
        freqm= new HashMap<>();
        keynodemap=new HashMap<>();
    }
    
    public int get(int key) {
        if(!keynodemap.containsKey(key)) return -1;

        node n= keynodemap.get(key);
        update(n);
        
        return n.val;
    }
    
    public void put(int key, int value) {
        if(keynodemap.containsKey(key)){
            node n= keynodemap.get(key);
            n.val=value;
            update(n);
            return ;
        }

        if(keynodemap.size()==capacity){
            dll curr= freqm.get(minfreq);
            node ex= curr.removelast();

            if(curr.size==0){
                freqm.remove(minfreq);
            }

            keynodemap.remove(ex.key);
        }

        node n= new node(key ,value,1);
        keynodemap.put(key , n);

        minfreq=1;
        freqm.computeIfAbsent(1 ,k->new dll()).addnode(n);
            
            
    }

    public void update(node n){
        dll curr=freqm.get(n.freq);
        curr.remove(n);

        if(curr.size==0 && minfreq==n.freq){
            freqm.remove(n.freq);
            minfreq++;
        }

        int key=n.freq+1;
        n.freq=key;

        freqm.computeIfAbsent(key ,k-> new dll()).addnode(n);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */