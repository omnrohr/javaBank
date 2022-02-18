package theOldCourse.smallBank.src.model;

import java.util.ArrayList;

public class SmallBank {
    private ArrayList<Branch> branches;

    public SmallBank() {
        this.branches = new ArrayList<>();
    }

    public SmallBank(SmallBank source) {
        this.branches = new ArrayList<>(source.branches);
    }

    public boolean addBranch(Branch branch){
        return branches.add(branch);
    }

    public boolean removeBranch(Branch branch){
        return branches.remove(branch);
    }

    public Branch setBranch(int index, Branch branch){
        return branches.set(index, branch);
    }

    @Override
    public String toString() {
        return "branches= " + branches;
    }
}
