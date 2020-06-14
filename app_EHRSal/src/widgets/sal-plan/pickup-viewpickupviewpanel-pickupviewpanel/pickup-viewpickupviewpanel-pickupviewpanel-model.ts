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
        name: 'nyear',
      },
      {
        name: 'createman',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'salplan',
        prop: 'salplanid',
      },
      {
        name: 'salplanname',
      },
      {
        name: 'enable',
      },
      {
        name: 'updateman',
      },
      {
        name: 'nmonth',
      },
      {
        name: 'state',
      },
      {
        name: 'memo',
      },
      {
        name: 'salschemename',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'salschemeid',
      },
    ]
  }


}