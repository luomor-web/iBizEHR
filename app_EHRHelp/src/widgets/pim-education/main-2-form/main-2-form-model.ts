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
        prop: 'pimeducationid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimeducationname',
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
        name: 'xl',
        prop: 'xl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'degree',
        prop: 'degree',
        dataType: 'SSCODELIST',
      },
      {
        name: 'xllx',
        prop: 'xllx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'xxxz',
        prop: 'xxxz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'qssj',
        prop: 'qssj',
        dataType: 'DATE',
      },
      {
        name: 'jssj',
        prop: 'jssj',
        dataType: 'DATE',
      },
      {
        name: 'byyx',
        prop: 'byyx',
        dataType: 'TEXT',
      },
      {
        name: 'sxzy',
        prop: 'sxzy',
        dataType: 'TEXT',
      },
      {
        name: 'sfdyxl',
        prop: 'sfdyxl',
        dataType: 'YESNO',
      },
      {
        name: 'sfzgxl',
        prop: 'sfzgxl',
        dataType: 'YESNO',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'TEXT',
      },
      {
        name: 'jlglbh',
        prop: 'jlglbh',
        dataType: 'TEXT',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'pimeducationid',
        prop: 'pimeducationid',
        dataType: 'GUID',
      },
      {
        name: 'pimeducation',
        prop: 'pimeducationid',
        dataType: 'FONTKEY',
      },
    ]
  }

}