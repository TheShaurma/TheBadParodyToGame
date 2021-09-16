import pygame


class ShowedField:
    """Objects of this class tracks of picture on transmitted him window."""

    def __init__(self, window_resolution, field_resolution):
        self._window = pygame.display.set_mode(window_resolution)
        self._window.fill((0x00, 0x00, 0x00))

        self._window_x_min = 0
        self._window_x_max = window_resolution[0]
        self._window_y_min = 0
        self._window_y_max = window_resolution[1]

        self._field_x_min = 0
        self._field_x_max = field_resolution[0]
        self._field_y_min = 0
        self._field_y_max = field_resolution[1]

        self.__prepare_to___from_pos_on_field_to_pos_on_windows_call()

    def set_field(self, field):
        self.__field = field

    def __prepare_to___from_pos_on_field_to_pos_on_windows_call(self):
        field_length = self._field_y_max-self._field_x_min+1
        field_heigh = self._field_y_max-self._field_y_min+1

        window_length = self._window_x_max-self._window_x_min+1
        window_heigh = self._window_y_max-self._window_y_min+1

        self.__rect_length = window_length // field_length
        self.__rect_heigh = window_heigh // field_heigh

        self.__y_remainder = window_heigh - self.__rect_heigh*field_heigh

    def __from_pos_on_field_to_pos_on_window(self, pos_on_field):
        x, y = pos_on_field

        x *= self.__rect_length

        y *= self.__rect_heigh
        y = self._window_y_max-y-self.__rect_heigh - self.__y_remainder

        pos = (x, y)

        return pos

    def __from_pos_on_window_to_pos_on_field(self, pos_on_window):
        x, y = pos_on_window
        y = self._window_y_max - y - self.__y_remainder

        x //= self.__rect_length
        y //= self.__rect_heigh

        pos = (x, y)

        return pos

    def window_update(self):
        self._show_field()
        self._mouse_pos_update()

        pygame.display.update()

    def _show_field(self):
        # TODO: Optimise me!
        self._window.fill((0x00, 0x00, 0x00))

        for pos_on_field in self.__field:
            pos_on_window = self.__from_pos_on_field_to_pos_on_window(
                pos_on_field)
            try:
                pygame.draw.rect(
                    self._window,
                    self.__field[pos_on_field].rgb,
                    (*pos_on_window, self.__rect_length, self.__rect_heigh)
                )
            except AttributeError:
                pygame.draw.rect(
                    self._window,
                    (0xFA, 0xCE, 0x04),
                    (*pos_on_window, self.__rect_length, self.__rect_heigh)
                )

    def _get_mouse_pos(self):
        mouse_pos = pygame.mouse.get_pos()

        x, y = mouse_pos

        return (x, y)

    def _mouse_pos_update(self):
        mouse_pos_on_window = self._get_mouse_pos()
        self.mouse_pos_on_field = self.__from_pos_on_window_to_pos_on_field(
            mouse_pos_on_window)

        pygame.draw.rect(
            self._window,
            (0xAA, 0xAA, 0xAA),
            (
                *self.__from_pos_on_field_to_pos_on_window(self.mouse_pos_on_field),
                self.__rect_length, self.__rect_heigh
            )
        )

    mouse_pos_on_field = (0, 0)


if __name__ == '__main__':
    pygame.init()
    v_field = ShowedField((500, 500), (10, 10))
    pygame.display.set_caption('ShowedField test...')

    v_field.set_field({
        (10, 10): None,
        (0, 10): None,
        (0, 0): None,
        (10, 0): None
    })

    input()
    pygame.quit()
