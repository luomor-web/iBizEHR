/**
 * OrmOrgTree 部件模型
 *
 * @export
 * @class OrmOrgTreeModel
 */
export default class OrmOrgTreeModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof OrmOrgTreeModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'socarchives',
        prop: 'socarchivesid',
      },
      {
        name: 'socarchivesname',
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
        name: 'pimpersonid',
      },
      {
        name: 'pimpersonname',
      },
      {
        name: 'socaccountid',
      },
      {
        name: 'socaccountname',
      },
      {
        name: 'socruleid',
      },
      {
        name: 'socrulename',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'ormorgsectorid',
      },
      {
        name: 'ormorgsectorname',
      },
      {
        name: 'ygbh',
      },
      {
        name: 'state',
      },
      {
        name: 'ygzt',
      },
    ]
  }


}