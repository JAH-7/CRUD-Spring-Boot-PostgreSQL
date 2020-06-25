CREATE TABLE IF NOT EXISTS "public"."tbl_person" (
    "person_id" character varying(20) NOT NULL,
    "first_name" character varying(255) NOT NULL,
    "last_name" character varying(255) NOT NULL,
    "phone" character varying(20) NOT NULL,
    "email" character varying(255) NOT NULL,
    "doc_type" numeric(1,0) NOT NULL,
    "doc_number" character varying(20) NOT NULL,
    "created_user" character varying(255) NOT NULL,
    "created_date" timestamp(6) NOT NULL,
    "last_modified_user" character varying(255) NOT NULL,
    "last_modified_date" timestamp(6) NOT NULL,
    "is_able_to_transfer" numeric(1,0) DEFAULT '0' NOT NULL,
    "country_code" character varying(20) DEFAULT '''51''' NOT NULL,
    CONSTRAINT "TBL_PERSON_PERSON_ID" PRIMARY KEY ("person_id")
) WITH (oids = false);

COMMENT ON COLUMN "public"."tbl_person"."person_id" IS 'Código Persona';

COMMENT ON COLUMN "public"."tbl_person"."first_name" IS 'Nombres';

COMMENT ON COLUMN "public"."tbl_person"."last_name" IS 'Apellidos';

COMMENT ON COLUMN "public"."tbl_person"."phone" IS 'Teléfono';

COMMENT ON COLUMN "public"."tbl_person"."email" IS 'Correo Electrónico';

COMMENT ON COLUMN "public"."tbl_person"."doc_type" IS 'Tipo de documento';

COMMENT ON COLUMN "public"."tbl_person"."doc_number" IS 'Número de documento';

COMMENT ON COLUMN "public"."tbl_person"."created_user" IS 'Usuario creador';

COMMENT ON COLUMN "public"."tbl_person"."created_date" IS 'Fecha de creación';

COMMENT ON COLUMN "public"."tbl_person"."last_modified_user" IS 'Usuario modificador';

COMMENT ON COLUMN "public"."tbl_person"."last_modified_date" IS 'Fecha de modificación';

COMMENT ON COLUMN "public"."tbl_person"."is_able_to_transfer" IS '0: NO ha validado Transferencias Persona a persona ,1: SI ha validado Transferencias Persona a persona';

COMMENT ON COLUMN "public"."tbl_person"."country_code" IS 'Código de Pais';

CREATE TABLE IF NOT EXISTS "public"."tbl_role" (
    "role_id" numeric(10,0) NOT NULL,
    "description" character varying(20) NOT NULL,
    "created_user" character varying(50) NOT NULL,
    "created_date" timestamp(6) NOT NULL,
    "last_modified_user" character varying(50) NOT NULL,
    "last_modified_date" timestamp(6) NOT NULL,
    CONSTRAINT "TBL_ROLE_ROLE_ID" PRIMARY KEY ("role_id")
) WITH (oids = false);

COMMENT ON COLUMN "public"."tbl_role"."role_id" IS 'Código Rol';

COMMENT ON COLUMN "public"."tbl_role"."description" IS 'Descripción Rol';

COMMENT ON COLUMN "public"."tbl_role"."created_user" IS 'Usuario creador';

COMMENT ON COLUMN "public"."tbl_role"."created_date" IS 'Fecha de creación';

COMMENT ON COLUMN "public"."tbl_role"."last_modified_user" IS 'Usuario modificador';

COMMENT ON COLUMN "public"."tbl_role"."last_modified_date" IS 'Fecha de modificación';


CREATE TABLE IF NOT EXISTS "public"."tbl_user" (
    "user_id" bigint NOT NULL,
    "person_id" character varying(20) NOT NULL,
    "created_user" character varying(255) NOT NULL,
    "created_date" timestamp(6) NOT NULL,
    "last_modified_user" character varying(255) NOT NULL,
    "last_modified_date" timestamp(6) NOT NULL,
    "user_name" character varying(255) NOT NULL,
    "password" character varying(255) NOT NULL,
    "flag_temp" integer NOT NULL,
    "status" integer DEFAULT '0' NOT NULL,
    "register_step" integer DEFAULT '3' NOT NULL,
    "term_condition" integer NOT NULL,
    "privacy_policy" integer NOT NULL,
    "is_able_to_pay" integer NOT NULL,
    "social_id" character varying(255) NOT NULL,
    "social type" integer NOT NULL,
    "uuid" character varying(50),
    "is_our_client" integer DEFAULT '0' NOT NULL,
    "unique_code" character varying(20),
    CONSTRAINT "TBL_USER_USER_ID" PRIMARY KEY ("user_id"),
    CONSTRAINT "TBL_USER_PERSON_ID_fkey" FOREIGN KEY (person_id) REFERENCES tbl_person(person_id) NOT DEFERRABLE
) WITH (oids = false);

COMMENT ON COLUMN "public"."tbl_user"."user_id" IS 'Código Usuario';

COMMENT ON COLUMN "public"."tbl_user"."person_id" IS 'Código Persona';

COMMENT ON COLUMN "public"."tbl_user"."created_user" IS 'Usuario creador';

COMMENT ON COLUMN "public"."tbl_user"."created_date" IS 'Fecha de creación';

COMMENT ON COLUMN "public"."tbl_user"."last_modified_user" IS 'Usuario modificador';

COMMENT ON COLUMN "public"."tbl_user"."last_modified_date" IS 'Fecha de modificación';

COMMENT ON COLUMN "public"."tbl_user"."user_name" IS 'Nombre del Usuario';

COMMENT ON COLUMN "public"."tbl_user"."password" IS 'Contraseña';

COMMENT ON COLUMN "public"."tbl_user"."flag_temp" IS '0:Activo 1:Inactivo';

COMMENT ON COLUMN "public"."tbl_user"."status" IS '0:Activo 1:Inactivo';

COMMENT ON COLUMN "public"."tbl_user"."register_step" IS '0:Comercio 1:Local 2:Cuenta 3:Fin';

COMMENT ON COLUMN "public"."tbl_user"."is_able_to_pay" IS 'Indicador que verifica si tiene cuenta o tarjeta asociada';

COMMENT ON COLUMN "public"."tbl_user"."social_id" IS 'Identificador de red social';

COMMENT ON COLUMN "public"."tbl_user"."social type" IS 'Tipo de red social';

COMMENT ON COLUMN "public"."tbl_user"."is_our_client" IS 'Metodo de pago es de interbank';

COMMENT ON COLUMN "public"."tbl_user"."unique_code" IS 'Codigo unico de cliente creado en Interbank';


CREATE TABLE IF NOT EXISTS "public"."tbl_user_role" (
    "user_role_id" bigint NOT NULL,
    "role_id" bigint NOT NULL,
    "user_id" bigint NOT NULL,
    "description" character varying(20) NOT NULL,
    "created_user" character varying(50) NOT NULL,
    "created_date" timestamp(6) NOT NULL,
    "last_modified_user" character varying(50) NOT NULL,
    "last_modified_date" timestamp(6) NOT NULL,
    CONSTRAINT "TBL_USER_ROLE_ROLE_ID" UNIQUE ("role_id"),
    CONSTRAINT "TBL_USER_ROLE_USER_ID" UNIQUE ("user_id"),
    CONSTRAINT "TBL_USER_ROLE_USER_ROLE_ID" PRIMARY KEY ("user_role_id"),
    CONSTRAINT "TBL_USER_ROLE_ROLE_ID_fkey" FOREIGN KEY (role_id) REFERENCES tbl_role(role_id) NOT DEFERRABLE,
    CONSTRAINT "TBL_USER_ROLE_USER_ID_fkey" FOREIGN KEY (user_id) REFERENCES tbl_user(user_id) NOT DEFERRABLE
) WITH (oids = false);

COMMENT ON COLUMN "public"."tbl_user_role"."user_role_id" IS 'Código Usuario Rol';

COMMENT ON COLUMN "public"."tbl_user_role"."role_id" IS 'Código Rol';

COMMENT ON COLUMN "public"."tbl_user_role"."user_id" IS 'Código de Usuario';

COMMENT ON COLUMN "public"."tbl_user_role"."description" IS 'Descripción Rol';

COMMENT ON COLUMN "public"."tbl_user_role"."created_user" IS 'Usuario creador';

COMMENT ON COLUMN "public"."tbl_user_role"."created_date" IS 'Fecha de creación';

COMMENT ON COLUMN "public"."tbl_user_role"."last_modified_user" IS 'Usuario modificador';

COMMENT ON COLUMN "public"."tbl_user_role"."last_modified_date" IS 'Fecha de modificación';

