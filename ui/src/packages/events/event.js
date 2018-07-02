// @flow
/* eslint-disable no-undef */

export const REDIRECT_EVENT_NAME = 'iataaa-redirect';

export const dispatchRedirectionEvent = (): boolean => window.dispatchEvent(
  new CustomEvent(REDIRECT_EVENT_NAME, {
    detail: 'redirection event',
  })
);
