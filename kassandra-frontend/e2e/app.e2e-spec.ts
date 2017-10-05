import { KassandraFrontendPage } from './app.po';

describe('kassandra-frontend App', function() {
  let page: KassandraFrontendPage;

  beforeEach(() => {
    page = new KassandraFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
