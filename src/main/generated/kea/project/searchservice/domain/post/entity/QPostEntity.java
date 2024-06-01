package kea.project.searchservice.domain.post.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPostEntity is a Querydsl query type for PostEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostEntity extends EntityPathBase<PostEntity> {

    private static final long serialVersionUID = -1519404371L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPostEntity postEntity = new QPostEntity("postEntity");

    public final kea.project.searchservice.global.common.entity.QBaseEntity _super = new kea.project.searchservice.global.common.entity.QBaseEntity(this);

    public final kea.project.searchservice.domain.blog.entity.QBlogEntity blog;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mainHashtag = createString("mainHashtag");

    public final kea.project.searchservice.domain.member.entity.QMemberEntity member;

    public final EnumPath<kea.project.searchservice.domain.post.vo.PostEntityType> postEntityType = createEnum("postEntityType", kea.project.searchservice.domain.post.vo.PostEntityType.class);

    public final EnumPath<kea.project.searchservice.domain.post.vo.PostEntityState> postState = createEnum("postState", kea.project.searchservice.domain.post.vo.PostEntityState.class);

    public final StringPath preview = createString("preview");

    public final StringPath thumbnail = createString("thumbnail");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPostEntity(String variable) {
        this(PostEntity.class, forVariable(variable), INITS);
    }

    public QPostEntity(Path<? extends PostEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPostEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPostEntity(PathMetadata metadata, PathInits inits) {
        this(PostEntity.class, metadata, inits);
    }

    public QPostEntity(Class<? extends PostEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blog = inits.isInitialized("blog") ? new kea.project.searchservice.domain.blog.entity.QBlogEntity(forProperty("blog"), inits.get("blog")) : null;
        this.member = inits.isInitialized("member") ? new kea.project.searchservice.domain.member.entity.QMemberEntity(forProperty("member"), inits.get("member")) : null;
    }

}

