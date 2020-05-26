/**
 * MPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class MPickupViewpickupviewpanelModel
 */
export default class MPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof MPickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'titletype',
      },
      {
        name: 'ormtitlename',
      },
      {
        name: 'ormtitle',
        prop: 'ormtitleid',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'createman',
      },
    ]
  }


}