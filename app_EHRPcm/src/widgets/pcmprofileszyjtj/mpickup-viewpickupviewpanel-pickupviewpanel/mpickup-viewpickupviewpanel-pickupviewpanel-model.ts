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
        name: 'createman',
      },
      {
        name: 'xh',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createdate',
      },
      {
        name: 'pcmprofileszyjtj',
        prop: 'pcmprofileszyjtjid',
      },
      {
        name: 'yglx',
      },
      {
        name: 'pcmprofileszyjtjname',
      },
      {
        name: 'updateman',
      },
    ]
  }


}