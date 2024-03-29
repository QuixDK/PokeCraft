package ru.pokecraft.site.constants;

public class ExceptionMessages {
    public static final String usernameIsUsedExceptionMessage = "Пользователь с таким именем уже существует! Попробуйте другое имя";
    public static final String wrongAuthParamExceptionMessage = "Неправильное имя пользователя или пароль";
    public static final String blankUsernameExceptionMessage = "Имя пользователя не может быть пустым";
    public static final String blankPasswordExceptionMessage = "Пароль не может быть пустым";
    public static final String usernamePatternException = "Имя пользователя может содержать только латиницу и цифры";
    public static final String passwordPatternException = "Пароль должен содержать как минимум одну цифру, латинскую букву в нижнем и врехнем регистре, специальный символ: @#$%^&+=_";
    public static final String blankEmailExceptionMessage = "Поле почта не может быть пустым";
}