import realization.field as field
from realization.mouse_keys_and_events_checker import *
import visualization
import config


class MainGame:
    # init metods ######################################
    def __init__(self):
        self._field = None
        self._player = None
        self.__checker = checkers.Checker()

        self._game_objects = []

    def set_field(self, field):
        self._field = field
        self._showed_field = visualization.showed_field.ShowedField(
            field_resolution=(config.FIELD_X_MAX, config.FIELD_Y_MAX),
            window_resolution=(config.WINDOW_X_MAX, config.WINDOW_Y_MAX))
        self._showed_field.set_field(self._field)

    def set_player(self, player):
        self._player = player
    ####################################################

    def append_game_objects(self, *poses_and_classes):
        for pos, clss in poses_and_classes:
            obj = clss(self._field, pos)
            self._game_objects.append(obj)

    def iteration(self):
        # check keys and events
        try:
            if self.__checker[constants.K_DOWN]:
                try:
                    self._player.move_down()
                except field.PositionError:
                    pass
            if self.__checker[constants.K_RIGHT]:
                try:
                    self._player.move_right()
                except field.PositionError:
                    pass
            if self.__checker[constants.K_UP]:
                try:
                    self._player.move_up()
                except field.PositionError:
                    pass
            if self.__checker[constants.K_LEFT]:
                try:
                    self._player.move_left()
                except field.PositionError:
                    pass
            if self.__checker[constants.QUIT]:
                raise QuitError()

        except AttributeError:
            if self._player is None:
                pass

        # call iteration metods on all game objects
        for obj in self._game_objects:
            try:
                obj.iteration()
            except AttributeError:
                pass

        # showed field update
        self._showed_field.window_update()


class QuitError(Exception):
    def __str__(self):
        return 'Game was quited...'
