/**
 * NotPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class NotPickupViewpickupviewpanelModel
 */
export default class NotPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof NotPickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'orgid',
      },
      {
        name: 'dh',
      },
      {
        name: 'titletype',
      },
      {
        name: 'zclc',
      },
      {
        name: 'pimtitlecataloguename',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'zcdj',
      },
      {
        name: 'enable',
      },
      {
        name: 'createman',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'pxh',
      },
      {
        name: 'pimtitlecatalogue',
        prop: 'pimtitlecatalogueid',
      },
      {
        name: 'pimtitlecataloguename2',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'pimtitlecatalogueid2',
      },
    ]
  }


}