package kea.project.searchservice.domain.blog.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBlogEntity is a Querydsl query type for BlogEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBlogEntity extends EntityPathBase<BlogEntity> {

    private static final long serialVersionUID = -1407245647L;

    public static final QBlogEntity blogEntity = new QBlogEntity("blogEntity");

    public final kea.project.searchservice.global.common.entity.QBaseEntity _super = new kea.project.searchservice.global.common.entity.QBaseEntity(this);

    public final StringPath about = createString("about");

    public final EnumPath<kea.project.searchservice.domain.blog.vo.BlogEntityState> blogEntityState = createEnum("blogEntityState", kea.project.searchservice.domain.blog.vo.BlogEntityState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath headerImage = createString("headerImage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QBlogEntity(String variable) {
        super(BlogEntity.class, forVariable(variable));
    }

    public QBlogEntity(Path<? extends BlogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBlogEntity(PathMetadata metadata) {
        super(BlogEntity.class, metadata);
    }

}

