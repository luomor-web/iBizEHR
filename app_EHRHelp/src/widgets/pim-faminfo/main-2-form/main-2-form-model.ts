/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main_2Model
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
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimfaminfoid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimfaminfoname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'ybrgx',
        prop: 'ybrgx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimfaminfoname',
        prop: 'pimfaminfoname',
        dataType: 'TEXT',
      },
      {
        name: 'zjlx',
        prop: 'zjlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zjh',
        prop: 'zjh',
        dataType: 'TEXT',
      },
      {
        name: 'xb',
        prop: 'xb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'csrq',
        prop: 'csrq',
        dataType: 'DATE',
      },
      {
        name: 'nl',
        prop: 'nl',
        dataType: 'INT',
      },
      {
        name: 'gzdw',
        prop: 'gzdw',
        dataType: 'TEXT',
      },
      {
        name: 'zw',
        prop: 'zw',
        dataType: 'TEXT',
      },
      {
        name: 'zzmm',
        prop: 'zzmm',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sfjjllr',
        prop: 'sfjjllr',
        dataType: 'SSCODELIST',
      },
      {
        name: 'telphone',
        prop: 'telphone',
        dataType: 'TEXT',
      },
      {
        name: 'sruvivors',
        prop: 'sruvivors',
        dataType: 'YESNO',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pimfaminfoid',
        prop: 'pimfaminfoid',
        dataType: 'GUID',
      },
      {
        name: 'pimfaminfo',
        prop: 'pimfaminfoid',
        dataType: 'FONTKEY',
      },
    ]
  }

}