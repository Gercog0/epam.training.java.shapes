package by.training.homework1.entity;

import by.training.homework1.util.IdGenerator;

public abstract class PlaneFigure {
    enum Type {
        TRIANGLE, QUADRANGLE, ELLIPSE;
    }

    private int id;
    private Type type;

    public PlaneFigure() {
        id = IdGenerator.generateId();
    }

    public PlaneFigure(Type type) {
        this();
        this.type = type;
    }

    public PlaneFigure(int id, Type type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaneFigure planeFigure = (PlaneFigure) o;

        if (id != planeFigure.id) return false;
        return type == planeFigure.type;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Figure: ");
        stringBuilder.append("id: ").append(id);
        stringBuilder.append(", type: ").append(type);
        return stringBuilder.toString();
    }
}
