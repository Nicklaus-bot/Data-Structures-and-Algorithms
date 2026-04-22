import java.util.*;
public class ImplementHashmap{
    public static class HashMap<K , V>{
        private class HMNode{
            K key;
            V value;

            HMNode(K key , V value){
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private LinkedList<HMNode> [] buckets;

        public HashMap(){
            initiatebuckets(4);
            size = 0;
        }

        private void initiatebuckets(int N){
            buckets = new LinkedList[N];
            for(int bi=0 ; bi<N ; bi++){
                buckets[bi] = new LinkedList();
            }
        }

         private int hashfn(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int getindexwithinbucket(K key , int bi){
            int di = 0;
            for(HMNode node : buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }

        public void put(K key , V value){
            int bi = hashfn(key);
            int di = getindexwithinbucket(key , bi);

            if(di != -1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }
            else{
                HMNode node = new HMNode(key , value);
                buckets[bi].add(node);
                size++;
            }

            double lambda = size * 1.0 / buckets.length;
            if(lambda > 2){
                rehash();
            }
        }

        private void rehash(){
            LinkedList<HMNode> [] oba = buckets;

            initiatebuckets(oba.length * 2);
            size = 0;

            for(int i=0 ; i<oba.length ; i++){
                for(HMNode node : oba[i]){
                    put(node.key , node.value);
                }
            }
        }

        public V get(K key) throws Exception{
            int bi = hashfn(key);
            int di = getindexwithinbucket(key , bi);

            if(di != -1){
                HMNode node = buckets[bi].get(di);
                return node.value;
            }
            else{
                return null;
            }
        }

        public boolean containsKey(K key){
            int bi = hashfn(key);
            int di = getindexwithinbucket(key , bi);

            if(di != -1){
                return true;
            }
            else{
                return false;
            }
        }

        public int size(){
            return size;
        }

        public V remove(K key) throws Exception{
            int bi = hashfn(key);
            int di = getindexwithinbucket(key , bi);

            if(di != -1){
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
            else{
                return null;
            }
        }

        public ArrayList<K> keySet() throws Exception{
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0 ; i<buckets.length ; i++){
                for(HMNode node : buckets[i]){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public void display(){
            System.out.println("Display Begins");
            for(int bi = 0 ; bi < buckets.length ; bi++){
                System.out.print("Bucket" + bi + " ");
                for(HMNode node : buckets[bi]){
                    System.out.print(node.key + " @ "  + node.value + " ");
                }
                System.out.println();
            }
            System.out.println("Display Ends");
        }
    }
    public static void main(String [] args) throws Exception{

        // Handle Input Output
        
    }
}