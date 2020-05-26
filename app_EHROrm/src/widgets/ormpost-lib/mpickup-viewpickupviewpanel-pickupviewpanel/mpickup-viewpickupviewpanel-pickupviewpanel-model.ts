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
        name: 'mustexcyear',
      },
      {
        name: 'postnature',
      },
      {
        name: 'createdate',
      },
      {
        name: 'jobdesc',
      },
      {
        name: 'ormpostlib',
        prop: 'ormpostlibid',
      },
      {
        name: 'gwflag',
      },
      {
        name: 'sugexcyear',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'gwtype',
      },
      {
        name: 'isconfidential',
      },
      {
        name: 'createman',
      },
      {
        name: 'ormpostlibname',
      },
      {
        name: 'updateman',
      },
    ]
  }


}