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
        name: 'ormorgdzid',
      },
      {
        name: 'ormbmkqdzname',
      },
      {
        name: 'createdate',
      },
      {
        name: 'createman',
      },
      {
        name: 'ormbmkqdz',
        prop: 'ormbmkqdzid',
      },
      {
        name: 'lng',
      },
      {
        name: 'sfmrkqdz',
      },
      {
        name: 'updateman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'lat',
      },
      {
        name: 'xh',
      },
      {
        name: 'ormorgsectorname',
      },
      {
        name: 'ormorgsectorid',
      },
      {
        name: 'attendancerange',
      },
    ]
  }


}