/**
 * Default_2 部件模型
 *
 * @export
 * @class Default_2Model
 */
export default class Default_2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Default_2Model
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
        name: 'n_pimtitlecataloguename_like',
        prop: 'pimtitlecataloguename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_zcdj_eq',
        prop: 'zcdj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_sfzgzc_eq',
        prop: 'sfzgzc',
        dataType: 'YESNO',
      },
    ]
  }

}