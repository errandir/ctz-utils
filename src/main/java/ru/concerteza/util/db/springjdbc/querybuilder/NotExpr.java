package ru.concerteza.util.db.springjdbc.querybuilder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * User: alexkasko
 * Date: 11/7/12
 */
class NotExpr extends AbstractExpr {
    private static final long serialVersionUID = 6586137146884967119L;

    private final Expression expr;

    NotExpr(Expression expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "not (" + expr + ")";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        NotExpr that = (NotExpr) o;
        return new EqualsBuilder()
                .append(expr, that.expr)
                .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(expr)
                .toHashCode();
    }
}
