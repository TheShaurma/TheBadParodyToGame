from realization.mouse_keys_and_events_checker import *
import visualization
import config


class MainGame:

    """Logic for game control.

    Visualization is controlled by object of this class.

    Raises:
        QuitError: while player want to exit.
    """

    # init metods ######################################
    def __init__(self):
        """Initialize a object who will be control the game.

        But the object requires field and player objects before as
        game will start.

        """

        self._field = None
        self._player = None
        self.__checker = checkers.Checker()

        self._game_objects = []

    def set_field(self, field):
        """Set a field object for this game.

        This method existences because possible then the field object be required by
        a something other in program.

        Args:
            field (realization.field.Field(recommended)): field who will be set.

        """

        self._field = field
        self._showed_field = visualization.showed_field.ShowedField(
            field_resolution=(config.FIELD_X_MAX, config.FIELD_Y_MAX),
            window_resolution=(config.WINDOW_X_MAX, config.WINDOW_Y_MAX))
        self._showed_field.set_field(self._field)

    def set_player(self, player):
        """Set a player object for this game.

        This method existences because possible then the player object be required by
        a something other in program.

        Args:
            field (realization.field.Field(recommended)): field how will be set.

        """

        self._player = player

    ####################################################

    def append_game_object(self, game_object):
        """Append a game object to a special list.

        Everything of this list will be called iteration method in iteration methon of
        this class. If someting of the special list has not iteration method then will
        be raised NoIterationMethodError.

        """
        if not hasattr(game_object, 'iteration'):
            raise NoIterationMethodError(game_object)

        self._game_objects.append(game_object)

    def iteration(self):
        """Iteration all game.

        Raises:
            QuitError: Player want to exit.
            HasNotGivenPlayerObjectError: name speaks for itself.
        """

        # check mouse position
        try:
            self._field[self.__old_mouse_pos_on_field].set_under_mouse_flag(
                False)
            self._field[self._showed_field.mouse_pos_on_field].set_under_mouse_flag(
                True)
        except AttributeError:
            pass
        self.__old_mouse_pos_on_field = self._showed_field.mouse_pos_on_field

        # check keys and events
        try:
            if self.__checker[constants.K_DOWN]:
                self._player.move_down()
            if self.__checker[constants.K_RIGHT]:
                self._player.move_right()
            if self.__checker[constants.K_UP]:
                self._player.move_up()
            if self.__checker[constants.K_LEFT]:
                self._player.move_left()
            if self.__checker[constants.QUIT]:
                raise QuitError()
        except AttributeError:
            if self._player is None:
                raise HasNotGivenPlayerObjectError(self)

        # call iteration metods on all game objects
        for obj in self._game_objects:
            obj.iteration()

        # showed field update
        self._showed_field.window_update()


class QuitError(Exception):
    def __str__(self):
        return 'Game was quited...'


class NoIterationMethodError(Exception):
    def __init__(self, obj): self.obj = obj

    def __str__(self):
        return '{obj} has not iteration method.'.format(obj=self.obj)


class HasNotGivenPlayerObjectError(Exception):
    def __init__(self, main_game_obj):
        self.main_game_obj = main_game_obj

    def __str__(self):
        return 'Has not given player object.'
