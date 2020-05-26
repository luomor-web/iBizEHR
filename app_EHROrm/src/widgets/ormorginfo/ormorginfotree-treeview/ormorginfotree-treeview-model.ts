/**
 * ORMORGINFOTree 部件模型
 *
 * @export
 * @class ORMORGINFOTreeModel
 */
export default class ORMORGINFOTreeModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof ORMORGINFOTreeModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'postinfo',
      },
      {
        name: 'porgsectorid',
      },
      {
        name: 'ordernum',
      },
      {
        name: 'ouid',
      },
      {
        name: 'ormorginfo',
        prop: 'ormorginfoid',
      },
      {
        name: 'shortname',
      },
      {
        name: 'orgcode',
      },
      {
        name: 'startstopsign',
      },
      {
        name: 'porgid',
      },
      {
        name: 'orgtypename',
      },
      {
        name: 'createdate',
      },
      {
        name: 'createman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'belongregion',
      },
      {
        name: 'updateman',
      },
      {
        name: 'orgtype',
      },
      {
        name: 'substandard',
      },
      {
        name: 'ormorginfoname',
      },
    ]
  }


}