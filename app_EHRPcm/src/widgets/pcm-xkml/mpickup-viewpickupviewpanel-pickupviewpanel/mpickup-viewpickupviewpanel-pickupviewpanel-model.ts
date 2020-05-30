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
        name: 'nd',
      },
      {
        name: 'createdate',
      },
      {
        name: 'pcmxkmlname',
      },
      {
        name: 'updateman',
      },
      {
        name: 'pcmxkml',
        prop: 'pcmxkmlid',
      },
      {
        name: 'xh',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'xkml',
      },
    ]
  }


}