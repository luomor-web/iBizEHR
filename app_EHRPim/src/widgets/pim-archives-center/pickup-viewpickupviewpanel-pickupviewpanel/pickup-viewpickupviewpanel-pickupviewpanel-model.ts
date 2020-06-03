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
        name: 'cabinetno',
      },
      {
        name: 'createman',
      },
      {
        name: 'createdate',
      },
      {
        name: 'bnumber',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'position',
      },
      {
        name: 'pimarchivescenter',
        prop: 'archivescenterid',
      },
      {
        name: 'serialno',
      },
      {
        name: 'memo',
      },
      {
        name: 'updateman',
      },
      {
        name: 'archivescentername',
      },
      {
        name: 'orgid',
      },
      {
        name: 'layerno',
      },
      {
        name: 'enable',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'ormorgid',
      },
    ]
  }


}