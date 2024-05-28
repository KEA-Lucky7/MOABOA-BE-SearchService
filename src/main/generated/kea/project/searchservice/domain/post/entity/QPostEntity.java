package kea.project.searchservice.domain.post.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostEntity is a Querydsl query type for PostEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostEntity extends EntityPathBase<PostEntity> {

    private static final long serialVersionUID = -1519404371L;

    public static final QPostEntity postEntity = new QPostEntity("postEntity");

    public final NumberPath<Long> blogId = createNumber("blogId", Long.class);

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mainHashtag = createString("mainHashtag");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final EnumPath<kea.project.searchservice.domain.post.vo.PostEntityType> postEntityType = createEnum("postEntityType", kea.project.searchservice.domain.post.vo.PostEntityType.class);

    public final EnumPath<kea.project.searchservice.domain.post.vo.PostEntityState> postState = createEnum("postState", kea.project.searchservice.domain.post.vo.PostEntityState.class);

    public final StringPath thumbnail = createString("thumbnail");

    public final StringPath title = createString("title");

    public QPostEntity(String variable) {
        super(PostEntity.class, forVariable(variable));
    }

    public QPostEntity(Path<? extends PostEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostEntity(PathMetadata metadata) {
        super(PostEntity.class, metadata);
    }

}

