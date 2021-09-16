import pygame

from . import constants


class Checker:
    def __init__(self): pass

    def __getitem__(self, key):
        keys = pygame.key.get_pressed()
        if keys[self.__FROM_PYGAME_TO_CURRENT_PACAGE_CONSTANTS_DICT[key]]:
            return True

        for event in pygame.event.get():
            if event.type == self.__FROM_PYGAME_TO_CURRENT_PACAGE_CONSTANTS_DICT[key]:
                return True

        return False

    __FROM_PYGAME_TO_CURRENT_PACAGE_CONSTANTS_DICT = {
        constants.K_UP: pygame.K_UP,
        constants.K_DOWN: pygame.K_DOWN,
        constants.K_RIGHT: pygame.K_RIGHT,
        constants.K_LEFT: pygame.K_LEFT,
        constants.QUIT: pygame.QUIT
    }
