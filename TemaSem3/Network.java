import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();


    public Network() {
        this.nodes = nodes;
    }

    /**
     * scopul algoritmului este de a compara fiecare nod din relationship si vede daca au relatii cu celelalte noduri.
     * @param node
     * @return
     */
    public int getNodeImportance(Node node)
    {
        int importance=0;
       for(Node otherNode :this.nodes)
       {
        if(otherNode.equals(node))
        {
            continue;
        }
        if(node instanceof Person && otherNode instanceof Person) {
            Person person = (Person) node;
            Person otherPerson = (Person) otherNode;
            if (person.getRelationships().containsKey(otherPerson)) {
                importance++;
            }
        }
            else if(node instanceof Company && otherNode instanceof Company)
            {
                Company company =(Company) node;
                Company otherCompany =(Company) otherNode;
                if(company.getRelationships().containsKey(otherCompany))
                {
                    importance++;
                }
            }
            else {
                if(node instanceof Person){
                    Person person=(Person) node;
                    Company company=(Company) otherNode;
                    if(person.getRelationships().containsKey(company))
                    {
                        importance++;
                    }
                } else
                {
                    Company company=(Company) node;
                    Person person=(Person) otherNode;
                    if(company.getRelationships().containsKey(person)) {
                        importance++;
                    }

                }
            }
        }

        return importance;
    }

    /**
     * Pentru fiecare nod face comparatie si afiseaza in ordine descrescatoare
     */
    public void printNetworkByImportance(){
        Collections.sort(this.nodes,(node1,node2)->{
            int importanta1=getNodeImportance(node1);
            int importanta2=getNodeImportance(node2);
            return Integer.compare(importanta1, importanta2);
        });
        for(Node node:this.nodes)
            System.out.println(node.getName()+" are importanta: " + getNodeImportance(node));


        }





    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node)
    {
        nodes.add(node);
        

    }

    public int getNumberOfNodes() {
        return nodes.size();
    }
    public void removeNode(Node node) {
        nodes.remove(node);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}' ;

    }


}