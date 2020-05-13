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
        name: 'n_pimpersonname_like',
        prop: 'pimpersonname',
        dataType: 'TEXT',
      },
      {
        name: 'n_ygbh_like',
        prop: 'ygbh',
        dataType: 'TEXT',
      },
      {
        name: 'n_zjhm_like',
        prop: 'zjhm',
        dataType: 'TEXT',
      },
      {
        name: 'n_zzdzs_like',
        prop: 'zzdzs',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_shortname_like',
        prop: 'shortname',
        dataType: 'PICKUPDATA',
      },
    ]
  }

}