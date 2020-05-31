/**
 * Default 部件模型
 *
 * @export
 * @class DefaultModel
 */
export default class DefaultModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DefaultModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'n_ygbh_like',
        prop: 'ygbh',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_dabh_like',
        prop: 'dabh',
        dataType: 'TEXT',
      },
      {
        name: 'n_ygzt_eq',
        prop: 'ygzt',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_dastate_eq',
        prop: 'dastate',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zt_eq',
        prop: 'zt',
        dataType: 'SSCODELIST',
      },
    ]
  }

}