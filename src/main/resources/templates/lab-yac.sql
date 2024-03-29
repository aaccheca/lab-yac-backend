PGDMP                      |            lab-yac    16.1    16.1 ,    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    33688    lab-yac    DATABASE     |   CREATE DATABASE "lab-yac" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "lab-yac";
                postgres    false            �            1259    33711    aulas    TABLE     �   CREATE TABLE public.aulas (
    id_aula integer NOT NULL,
    nombre_aula character varying(50) NOT NULL,
    estado boolean
);
    DROP TABLE public.aulas;
       public         heap    postgres    false            �            1259    33710    aulas_id_aula_seq    SEQUENCE     �   CREATE SEQUENCE public.aulas_id_aula_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.aulas_id_aula_seq;
       public          postgres    false    218            �           0    0    aulas_id_aula_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.aulas_id_aula_seq OWNED BY public.aulas.id_aula;
          public          postgres    false    217            �            1259    33737    horarios    TABLE     �   CREATE TABLE public.horarios (
    id_horario integer NOT NULL,
    id_aula integer,
    dia_semana character varying(20),
    hora_inicio character varying,
    hora_fin character varying,
    id_maestro integer
);
    DROP TABLE public.horarios;
       public         heap    postgres    false            �            1259    33736    horario_id_horario_seq    SEQUENCE     �   CREATE SEQUENCE public.horario_id_horario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.horario_id_horario_seq;
       public          postgres    false    222            �           0    0    horario_id_horario_seq    SEQUENCE OWNED BY     R   ALTER SEQUENCE public.horario_id_horario_seq OWNED BY public.horarios.id_horario;
          public          postgres    false    221            �            1259    41941    notificaciones    TABLE     �   CREATE TABLE public.notificaciones (
    id_notificacion integer NOT NULL,
    id_maestro integer,
    notificacion character varying
);
 "   DROP TABLE public.notificaciones;
       public         heap    postgres    false            �            1259    41940    notificaciones_id_seq    SEQUENCE     �   CREATE SEQUENCE public.notificaciones_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.notificaciones_id_seq;
       public          postgres    false    224            �           0    0    notificaciones_id_seq    SEQUENCE OWNED BY     \   ALTER SEQUENCE public.notificaciones_id_seq OWNED BY public.notificaciones.id_notificacion;
          public          postgres    false    223            �            1259    33718    registros_laboratorio    TABLE     M  CREATE TABLE public.registros_laboratorio (
    id_registro integer NOT NULL,
    id_usuario integer,
    id_aula integer,
    firma character varying(100),
    guardia_turno character varying(50),
    novedades character varying,
    fecha character varying,
    hora_ingreso character varying,
    hora_salida character varying
);
 )   DROP TABLE public.registros_laboratorio;
       public         heap    postgres    false            �            1259    33717 %   registros_laboratorio_id_registro_seq    SEQUENCE     �   CREATE SEQUENCE public.registros_laboratorio_id_registro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.registros_laboratorio_id_registro_seq;
       public          postgres    false    220            �           0    0 %   registros_laboratorio_id_registro_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.registros_laboratorio_id_registro_seq OWNED BY public.registros_laboratorio.id_registro;
          public          postgres    false    219            �            1259    33690    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    id_usuario integer NOT NULL,
    nombre_usuario character varying(50) NOT NULL,
    contrasena character varying(50) NOT NULL,
    tipo_usuario character varying(20) NOT NULL
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            �            1259    33689    usuarios_id_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuarios_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.usuarios_id_usuario_seq;
       public          postgres    false    216            �           0    0    usuarios_id_usuario_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.usuarios_id_usuario_seq OWNED BY public.usuarios.id_usuario;
          public          postgres    false    215            /           2604    33714 
   aulas id_aula    DEFAULT     n   ALTER TABLE ONLY public.aulas ALTER COLUMN id_aula SET DEFAULT nextval('public.aulas_id_aula_seq'::regclass);
 <   ALTER TABLE public.aulas ALTER COLUMN id_aula DROP DEFAULT;
       public          postgres    false    217    218    218            1           2604    33740    horarios id_horario    DEFAULT     y   ALTER TABLE ONLY public.horarios ALTER COLUMN id_horario SET DEFAULT nextval('public.horario_id_horario_seq'::regclass);
 B   ALTER TABLE public.horarios ALTER COLUMN id_horario DROP DEFAULT;
       public          postgres    false    222    221    222            2           2604    41944    notificaciones id_notificacion    DEFAULT     �   ALTER TABLE ONLY public.notificaciones ALTER COLUMN id_notificacion SET DEFAULT nextval('public.notificaciones_id_seq'::regclass);
 M   ALTER TABLE public.notificaciones ALTER COLUMN id_notificacion DROP DEFAULT;
       public          postgres    false    224    223    224            0           2604    33721 !   registros_laboratorio id_registro    DEFAULT     �   ALTER TABLE ONLY public.registros_laboratorio ALTER COLUMN id_registro SET DEFAULT nextval('public.registros_laboratorio_id_registro_seq'::regclass);
 P   ALTER TABLE public.registros_laboratorio ALTER COLUMN id_registro DROP DEFAULT;
       public          postgres    false    219    220    220            .           2604    33693    usuarios id_usuario    DEFAULT     z   ALTER TABLE ONLY public.usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuarios_id_usuario_seq'::regclass);
 B   ALTER TABLE public.usuarios ALTER COLUMN id_usuario DROP DEFAULT;
       public          postgres    false    216    215    216            �          0    33711    aulas 
   TABLE DATA           =   COPY public.aulas (id_aula, nombre_aula, estado) FROM stdin;
    public          postgres    false    218   |5       �          0    33737    horarios 
   TABLE DATA           f   COPY public.horarios (id_horario, id_aula, dia_semana, hora_inicio, hora_fin, id_maestro) FROM stdin;
    public          postgres    false    222   �5       �          0    41941    notificaciones 
   TABLE DATA           S   COPY public.notificaciones (id_notificacion, id_maestro, notificacion) FROM stdin;
    public          postgres    false    224   �5       �          0    33718    registros_laboratorio 
   TABLE DATA           �   COPY public.registros_laboratorio (id_registro, id_usuario, id_aula, firma, guardia_turno, novedades, fecha, hora_ingreso, hora_salida) FROM stdin;
    public          postgres    false    220   �6       �          0    33690    usuarios 
   TABLE DATA           X   COPY public.usuarios (id_usuario, nombre_usuario, contrasena, tipo_usuario) FROM stdin;
    public          postgres    false    216   ;7       �           0    0    aulas_id_aula_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.aulas_id_aula_seq', 1, true);
          public          postgres    false    217            �           0    0    horario_id_horario_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.horario_id_horario_seq', 7, true);
          public          postgres    false    221            �           0    0    notificaciones_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.notificaciones_id_seq', 5, true);
          public          postgres    false    223            �           0    0 %   registros_laboratorio_id_registro_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.registros_laboratorio_id_registro_seq', 7, true);
          public          postgres    false    219            �           0    0    usuarios_id_usuario_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.usuarios_id_usuario_seq', 15, true);
          public          postgres    false    215            6           2606    33716    aulas aulas_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.aulas
    ADD CONSTRAINT aulas_pkey PRIMARY KEY (id_aula);
 :   ALTER TABLE ONLY public.aulas DROP CONSTRAINT aulas_pkey;
       public            postgres    false    218            :           2606    33742    horarios horario_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.horarios
    ADD CONSTRAINT horario_pkey PRIMARY KEY (id_horario);
 ?   ALTER TABLE ONLY public.horarios DROP CONSTRAINT horario_pkey;
       public            postgres    false    222            <           2606    41948 "   notificaciones notificaciones_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.notificaciones
    ADD CONSTRAINT notificaciones_pkey PRIMARY KEY (id_notificacion);
 L   ALTER TABLE ONLY public.notificaciones DROP CONSTRAINT notificaciones_pkey;
       public            postgres    false    224            8           2606    33725 0   registros_laboratorio registros_laboratorio_pkey 
   CONSTRAINT     w   ALTER TABLE ONLY public.registros_laboratorio
    ADD CONSTRAINT registros_laboratorio_pkey PRIMARY KEY (id_registro);
 Z   ALTER TABLE ONLY public.registros_laboratorio DROP CONSTRAINT registros_laboratorio_pkey;
       public            postgres    false    220            4           2606    33695    usuarios usuarios_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    216            ?           2606    33743    horarios horario_id_aula_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.horarios
    ADD CONSTRAINT horario_id_aula_fkey FOREIGN KEY (id_aula) REFERENCES public.aulas(id_aula);
 G   ALTER TABLE ONLY public.horarios DROP CONSTRAINT horario_id_aula_fkey;
       public          postgres    false    4662    218    222            @           2606    41959     horarios horario_id_maestro_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.horarios
    ADD CONSTRAINT horario_id_maestro_fkey FOREIGN KEY (id_maestro) REFERENCES public.usuarios(id_usuario) NOT VALID;
 J   ALTER TABLE ONLY public.horarios DROP CONSTRAINT horario_id_maestro_fkey;
       public          postgres    false    222    216    4660            A           2606    41954 -   notificaciones notificaciones_id_usuario_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.notificaciones
    ADD CONSTRAINT notificaciones_id_usuario_fkey FOREIGN KEY (id_maestro) REFERENCES public.usuarios(id_usuario) NOT VALID;
 W   ALTER TABLE ONLY public.notificaciones DROP CONSTRAINT notificaciones_id_usuario_fkey;
       public          postgres    false    4660    224    216            =           2606    33731 8   registros_laboratorio registros_laboratorio_id_aula_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.registros_laboratorio
    ADD CONSTRAINT registros_laboratorio_id_aula_fkey FOREIGN KEY (id_aula) REFERENCES public.aulas(id_aula);
 b   ALTER TABLE ONLY public.registros_laboratorio DROP CONSTRAINT registros_laboratorio_id_aula_fkey;
       public          postgres    false    218    4662    220            >           2606    41949 ;   registros_laboratorio registros_laboratorio_id_usuario_fkey 
   FK CONSTRAINT     �   ALTER TABLE ONLY public.registros_laboratorio
    ADD CONSTRAINT registros_laboratorio_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuarios(id_usuario) NOT VALID;
 e   ALTER TABLE ONLY public.registros_laboratorio DROP CONSTRAINT registros_laboratorio_id_usuario_fkey;
       public          postgres    false    216    4660    220            �   J   x�3�t���,�2�t�;�˙�e����������`�3��t�J� I%�8C]<C�&�ec���� N      �   
   x������ � �      �   �   x�E��
1DcoS��!"�HnK�p��}!J��X]B8�7{�ݽu�1��)��L'&o�-H,*x���\���U#FB���9�)��\�d#�_DF�E�
<�v�'�<B�FG{�${aixZD�� p�3@      �   �   x�M�K
�0D��)|�Ɩ��	��	�Q�K.���_��m``lxF<t��4/�3��0����Y�Beۊ, ��r�@T� ��ۚ�ڂXwHޣjOlE;i�5��k律�d�I7骬ɲ������Tc���&� ����<�a�k��qlK��"~ �k9\      �   V   x�3���/JO�442615��ML-.)��2��)�,F5��/ND54�tN,���LL��̃	;�8�@�Ĕ�".CS��|;b���� &7)i     