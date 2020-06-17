/**
 * PickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class PickupViewpickupviewpanelModel
 */
export default class PickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof PickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'socarea',
        prop: 'socareaid',
      },
      {
        name: 'socareaname',
      },
      {
        name: 'enable',
      },
      {
        name: 'createman',
      },
      {
        name: 'updateman',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'memo',
      },
    ]
  }


}