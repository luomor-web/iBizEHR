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
        name: 'socrule',
        prop: 'socruleid',
      },
      {
        name: 'socrulename',
      },
      {
        name: 'createman',
      },
      {
        name: 'enable',
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
        name: 'nyear',
      },
      {
        name: 'memo',
      },
      {
        name: 'socareaid',
      },
      {
        name: 'socareaname',
      },
      {
        name: 'state',
      },
    ]
  }


}